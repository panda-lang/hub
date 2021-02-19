package org.panda_lang.hub.github

import kotlinx.serialization.Serializable

const val USER_INFO_URL = "https://api.github.com/user"

/*
{
"login":"dzikoysk",
"id":4235722,
"node_id":"MDQ6VXNlcjQyMzU3MjI=",
"avatar_url":"https://avatars.githubusercontent.com/u/4235722?v=4",
"gravatar_id":"","url":"https://api.github.com/users/dzikoysk",
"html_url":"https://github.com/dzikoysk",
"followers_url":"https://api.github.com/users/dzikoysk/followers","following_url":"https://api.github.com/users/dzikoysk/following{/other_user}",
"gists_url":"https://api.github.com/users/dzikoysk/gists{/gist_id}","starred_url":"https://api.github.com/users/dzikoysk/starred{/owner}{/repo}",
"subscriptions_url":"https://api.github.com/users/dzikoysk/subscriptions","organizations_url":"https://api.github.com/users/dzikoysk/orgs",
"repos_url":"https://api.github.com/users/dzikoysk/repos","events_url":"https://api.github.com/users/dzikoysk/events{/privacy}",
"received_events_url":"https://api.github.com/users/dzikoysk/received_events","type":"User","site_admin":false,"name":"Dzikoysk","company":"@panda-lang ",
"blog":"dzikoysk.net","location":"Poland, Warsaw","email":"dzikoysk@dzikoysk.net","hireable":true,"bio":"#onlypanda ? \r\n\r\n// @cyaffle - second account","twitter_username":"dzikoysk",
"public_repos":11,"public_gists":3,"followers":156,"following":5,"created_at":"2013-04-23T14:16:42Z","updated_at":"2021-02-18T12:54:59Z","private_gists":5,"total_private_repos":2,"
owned_private_repos":2,"disk_usage":288089,"collaborators":2,"two_factor_authentication":true,"plan":{"name":"pro","space":976562499,"collaborators":0,
"private_repos":9999}}
GitHubUser(login=dzikoysk)
 */
@Serializable
data class GitHubUser(
    val id: String,
    val login: String,
    val avatarUrl: String,
    val type: String,
    val name: String,
    val email: String
)