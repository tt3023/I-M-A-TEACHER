/**
 * Created by wgt on 17-2-3.
 */
/**
 * Created by wgt on 17-2-2.
 */
jQuery(document).ready(function () {
    var socket;
    if (!window.WebSocket) {

        window.WebSocket = window.MozWebSocket;
    }

    if (window.WebSocket) {
        socket = new WebSocket("ws://localhost:8081/webs");
        socket.onmessage = function (event) {
            alert(event.data);
        };
    } else {
        alert("您的浏览器不支持WebSocket协议！");
    }

    $('#nex').click(function () {
        var a = document.getElementById("next1");
        var b = document.getElementById("next2");
        a.style.display = "none";
        b.style.display = "block";

            var num = $('#num').val();
            var pass = $('#pwd').val();
            var pass1 = $('#pwd1').val();
            var message = " {'data':{'num':'" + num + "','pwd':''},'classname':'RegisteDao','mehtodname':'check'}";
            if (pass.trim()== pass1.trim()) {
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
                alert("两次密码不相同!")
            }
        }
    );

    $('#registe').click(function () {
            var num = $('#num').val();
            var pass = $('#pwd').val();
            var pass1 = $('#pwd1').val();
            var message = " {'data':{'num':'" + num + "','pwd':'" + pass + "'},'classname':'RegisteDao','mehtodname':'registe'}";
            if (pass.trim()== pass1.trim()) {
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
                alert("两次密码不相同!")
            }
        }
    );

});