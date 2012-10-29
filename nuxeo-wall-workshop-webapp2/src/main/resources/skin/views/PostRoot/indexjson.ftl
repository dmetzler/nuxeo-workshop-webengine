{posts:[
<#list This.getPosts() as post>
	{"title":"${post.title}","description":"${post.description}"},
</#list>
]}