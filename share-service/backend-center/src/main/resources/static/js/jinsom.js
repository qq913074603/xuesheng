function list_comments_show(obj)
{
    console.log($(obj).parent().parent().find('.lmlblog-post-footer-comments'));
    $(obj).parent().parent().find('.lmlblog-post-footer-comments').toggle('slow');
}

function lmlblog_like_posts(post,obj)
{
    $(obj).find('span').html('999');
    alert("点赞成功");
}