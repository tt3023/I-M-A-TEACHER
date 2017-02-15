/**
 * Created by wgt on 17-2-2.
 */
jQuery(document).ready(function () {
    var socket;
    if (!window.WebSocket) {

        window.WebSocket = window.MozWebSocket;
    }

    if (window.WebSocket) {
        socket = new WebSocket("ws://localhost:8081/login");
        socket.onmessage = function (event) {
            alert(event.data);
        };
    } else {
        alert("您的浏览器不支持WebSocket协议！");
    }

    $('#sig').click(function () {
            var num = $('#num').val();
            var pass = $('#pwd').val();
            var message = " {'data':{'num':'" + num + "','pwd':'" + pass + "'},'classname':'LoginDao','mehtodname':'login'}";
       /* var message = " {'data':{'num':'" + num + "','pwd':'" + pass + "'},'classname':'RegisteDao','mehtodname':'registe'}";*/
            if (pass.trim() != "" && num.trim() != "") {
                if (!window.WebSocket) {
                    return;
                }
                if (socket.readyState == WebSocket.OPEN) {
                    socket.send(message);
                } else {
                    alert("WebSocket 连接没有建立成功！");
                }
            }
            else {
                alert("not null")
            }
        }
    );

});