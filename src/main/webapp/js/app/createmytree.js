var paraMap={};
// $.ajax({
//     type:"POST",   //
//     url:'datarsdir/getMytree.do',
//     async:false,
//     data:JSON.stringify(paraMap),
//     //dataType:"json",
//     contentType:'application/json;charset=UTF-8',
//     success: function (result) {
//         var myJson = eval('(' + result + ')');
//         $('#myTree').combotree({
//             data: "[{ 'text':'.Net','state':'closed','children':[{'text':'C#'},{'text':'asp.Net'}]},{'text':'Java'}]"
//         });
//     }
// });


$('#myTree').combotree({
    data: "[{ 'text':'.Net','state':'closed','children':[{'text':'C#'},{'text':'asp.Net'}]},{'text':'Java'}]"
});