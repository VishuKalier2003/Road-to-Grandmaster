import requests

# Step 1: Get all contests
contest_res = requests.get("https://codeforces.com/api/contest.list").json()
contests = contest_res['result']

# Step 2: Extract Educational contest IDs
edu_contest_ids = set()
for c in contests:
    if "Educational" in c['name']:
        edu_contest_ids.add(c['id'])

# Step 3: Get problemset
problem_res = requests.get("https://codeforces.com/api/problemset.problems").json()
problems = problem_res['result']['problems']

filtered = []

for p in problems:
    if 'rating' not in p:
        continue

    # Correct Educational filter
    if p.get('contestId') not in edu_contest_ids:
        continue

    # Rating filter
    if not (900 <= p['rating'] <= 1200):
        continue

    # Tag filter
    if 'math' not in p.get('tags', []):
        continue

    filtered.append({
        "contestId": p['contestId'],
        "index": p['index'],
        "name": p['name'],
        "rating": p['rating']
    })

# Sort
filtered.sort(key=lambda x: (x['rating'], x['contestId']))

# Output
if not filtered:
    print("No problems found (check filters)")
else:
    for p in filtered:
        print(f"{p['contestId']}{p['index']} | {p['rating']} | {p['name']}")