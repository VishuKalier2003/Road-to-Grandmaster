import os
import zipfile
import json
from pathlib import Path

# CONFIGURATION
MAX_FILE_SIZE = 200_000      # bytes (truncate large files)
EXCLUDE_EXTENSIONS = {".pyc", ".class", ".jar", ".png", ".jpg", ".jpeg", ".gif", ".zip"}
EXCLUDE_FOLDERS = {".git", "node_modules", "__pycache__"}

def should_skip(file_path):
    if any(part in EXCLUDE_FOLDERS for part in file_path.parts):
        return True
    if file_path.suffix.lower() in EXCLUDE_EXTENSIONS:
        return True
    return False

def read_file_safe(path):
    try:
        with open(path, "r", encoding="utf-8", errors="ignore") as f:
            content = f.read(MAX_FILE_SIZE)
            truncated = f.tell() >= MAX_FILE_SIZE
        return content, truncated
    except:
        return None, False

def build_manifest(root_dir):
    manifest = []
    for file_path in Path(root_dir).rglob("*"):
        if file_path.is_file() and not should_skip(file_path):
            content, truncated = read_file_safe(file_path)

            manifest.append({
                "path": str(file_path.relative_to(root_dir)),
                "size": file_path.stat().st_size,
                "truncated": truncated,
                "content": content
            })
    return manifest

def create_zip(root_dir, output_zip="llm_ready_bundle.zip"):
    root_dir = Path(root_dir)

    manifest = build_manifest(root_dir)

    with zipfile.ZipFile(output_zip, "w", zipfile.ZIP_DEFLATED) as zf:
        # Add raw files
        for file_path in root_dir.rglob("*"):
            if file_path.is_file() and not should_skip(file_path):
                zf.write(file_path, arcname=file_path.relative_to(root_dir))

        # Add manifest JSON
        zf.writestr("manifest.json", json.dumps(manifest, indent=2))

    print(f"ZIP created: {output_zip}")
    print(f"Total files included: {len(manifest)}")


# USAGE
if __name__ == "__main__":
    folder_path = "/Users/vishu.kalier@zomato.com/Desktop/CP/Road-to-Grandmaster/Road-to-Grandmaster/z-cp-notes"  # change this
    create_zip(folder_path)