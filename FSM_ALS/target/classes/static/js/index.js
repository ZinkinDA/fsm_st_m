$(document).ready(function (){
    fsm();
});

function fsm(){
    $.get('/rest/controller/',function (fsm) {
        console.log(fsm);
        let view = '<tr><td>' + fsm.statement + '</td>'
            + '<td>' + fsm.mode  + '</td>'
            + '<td>' + fsm.water + '</td>'
            + '<td>' + fsm.heating + '</td>'
            + '<td>'
            +'<button onclick="setColdMode()">SET</button>'
            + '</td>'
            + '<td>'
            +'<button onclick="setHotMode()">SET</button>'
            + '</td>'
            + '<td>'
            +'<button onclick="Start()">GO</button>'
            + '</td>'
            + '</tr>';


        $('#fsm').html(view);
    });
};

function setColdMode() {
    alert("Вы поставили холодный режим!");
    $.ajax({
        url : '/rest/controller/modeCold',
        type : 'POST',
        cache: false
    });
    setTimeout(fsm, 300);
};

function setHotMode() {
    alert("Вы поставил горячий режим!");
    $.ajax({
        url : '/rest/controller/modeHot',
        type : 'post'
    });
    setTimeout(fsm,300);
};

function ON(){
    alert("Включаемся, подождите 2 секунды!");
    $.ajax({
        url : '/rest/controller/turnOn',
        type : 'post'
    });
    setTimeout(fsm, 2000);
};

function OFF(){
    alert("Выключаемся, подождите 2 секунды!");
    $.ajax({
        url : '/rest/controller/turnOff',
        type : 'post'
    });
    setTimeout(fsm, 2000);
};

function Start(){
    alert('Запуск');
    $.ajax({
        url : '/rest/controller/go',
        type : 'post'
    });

    setTimeout(fsm,200);
    setTimeout(fsm,2500);
    setTimeout(fsm,9000);
    setTimeout(fsm,13000);
    setTimeout(fsm,17000);
}
