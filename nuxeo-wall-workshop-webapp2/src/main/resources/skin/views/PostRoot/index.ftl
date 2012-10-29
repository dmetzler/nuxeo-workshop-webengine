<@extends src="base.ftl">
<@block name="header">You signed in as ${Context.principal}</@block>
<@block name="content">

<form action="${This.path}" method="post">
<input name="title"/><br/>
<textarea name="postcontent"></textarea>
<br/>
<input type="submit" value="Send Post"/>
</form>

<ul>
<#list This.getPosts() as post>
	<li>${post.title}<br/>${post.description}</li>
</#list>
</ul>
</@block>
</@extends>
