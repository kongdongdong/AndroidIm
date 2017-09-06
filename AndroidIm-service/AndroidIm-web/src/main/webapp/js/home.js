/**
 * Created by kdd on 17/9/4.
 */
/*个人信息*/
function myselfinfo(){
    layer.open({
        type: 1,
        area: ['300px','200px'],
        fix: false, //不固定
        maxmin: false,
        shade:0.4,
        title: '查看信息',
        content: '<div>管理员信息</div>'
    });
}