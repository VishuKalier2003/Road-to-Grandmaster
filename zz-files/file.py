import requests
from collections import defaultdict

res = requests.get("https://codeforces.com/api/problemset.problems?tags=math").json()
problems = {(p['contestId'], p['index']): p for p in res['result']['problems']}
stats = {(s['contestId'], s['index']): s['solvedCount'] for s in res['result']['problemStatistics']}

by_rating = defaultdict(list)
for key, p in problems.items():
    if p.get('rating') in [800, 900, 1000, 1100]:
        by_rating[p['rating']].append(stats.get(key, 0))

for r in [800, 900, 1000, 1100]:
    counts = sorted(by_rating[r], reverse=True)
    n = len(counts)
    print(f"\nRating {r} — {n} problems")
    print(f"  Top 3:       {counts[:3]}")
    print(f"  10th pct:    {counts[n//10]}")
    print(f"  25th pct:    {counts[n//4]}")
    print(f"  Median:      {counts[n//2]}")
    print(f"  75th pct:    {counts[3*n//4]}")
    print(f"  90th pct:    {counts[9*n//10]}")
    print(f"  Bottom 3:    {counts[-3:]}")