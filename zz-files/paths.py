from pathlib import Path

def list_md_files(root_folder):
    root = Path(root_folder).resolve()

    for file in root.rglob("*.md"):
        if file.is_file():  # ensures it's a file, not directory
            print(file.relative_to(root))

if __name__ == "__main__":
    root_path = input("Enter root folder path: ").strip()
    list_md_files(root_path)