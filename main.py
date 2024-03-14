import os 
from datetime import datetime
from pytz import timezone
from github import Github
import requests
import random

if __name__ == "__main__":
    access_token = os.environ['MY_GITHUB_TOKEN']
    repository_name = "algorithm-study"

    seoul_timezone = timezone('Asia/Seoul')
    today = datetime.now(seoul_timezone)
    now_year = int(today.strftime('%y'))
    now_month = int(today.strftime('%m'))
    now_day = int(today.strftime('%d'))
    week = int(now_day/7) + 1

    title = f"{now_year}년 {now_month}월 {week}주차 리뷰어 목록입니다."

    assignees = ["예진", "병룡", "주광", "윤선", "민협"]
    assignee_ids = ["fingersdanny", "Hju95", "yoonseon12", "yejincode", "GBGreenBravo"]
    reviewers = list(assignees) 
    labels = ["documentation", "ためらう開発者のために"]

    random.shuffle(assignees)
    random.shuffle(reviewers)

    while any(assignee == reviewer for assignee, reviewer in zip(assignees, reviewers)):
        random.shuffle(reviewers)

    # 테이블 헤더
    table_header = "| Assignee | Reviewer | \n| --- | --- |"

    # 테이블 내용 생성
    table_content = "\n".join(f"| {assignee} | {reviewer} |" for assignee, reviewer in zip(assignees, reviewers))

    # 전체 마크다운 생성
    markdown_content = f"<details>\n<summary> 토글 열어서 보시죠 </summary>\n<div markdown=\"1\">\n\n{table_header}\n{table_content}\n\n</div>\n</details>"

    g = Github(access_token)
    repo = g.get_organization("Kernel360-cell1").get_repo(repository_name)

    # 이슈 생성 및 assignee 추가
    issue = repo.create_issue(title=title, body=markdown_content, assignees=assignee_ids, labels=labels)

    print(f"이슈가 생성되었습니다. Assignees: {[assignee.login for assignee in issue.assignees]}")
