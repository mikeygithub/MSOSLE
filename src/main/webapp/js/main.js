//获取系统时间
var newDate = '';
getLangDate();
//值小于10时，在前面补0
function dateFilter(date){
    if(date < 10){return "0"+date;}
    return date;
}
function getLangDate(){
    var dateObj = new Date(); //表示当前系统时间的Date对象
    var year = dateObj.getFullYear(); //当前系统时间的完整年份值
    var month = dateObj.getMonth()+1; //当前系统时间的月份值
    var date = dateObj.getDate(); //当前系统时间的月份中的日
    var day = dateObj.getDay(); //当前系统时间中的星期值
    var weeks = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
    var week = weeks[day]; //根据星期值，从数组中获取对应的星期字符串
    var hour = dateObj.getHours(); //当前系统时间的小时值
    var minute = dateObj.getMinutes(); //当前系统时间的分钟值
    var second = dateObj.getSeconds(); //当前系统时间的秒钟值
    var timeValue = "" +((hour >= 12) ? (hour >= 18) ? "晚上" : "下午" : "上午" ); //当前时间属于上午、晚上还是下午
    newDate = dateFilter(year)+"年"+dateFilter(month)+"月"+dateFilter(date)+"日 "+" "+dateFilter(hour)+":"+dateFilter(minute)+":"+dateFilter(second);
    document.getElementById("nowTime").innerHTML = window.sessionStorage.getItem("userName")+timeValue+"好！ 欢迎使用人流量监管平台   当前时间为： "+newDate+"　"+week;
    setTimeout("getLangDate()",1000);
}

layui.config({
    base: $config.resUrl+"js/" //定义基目录
}).extend({
    $tool:'tool',
    $api:'api',
}).use(['form','element','layer','table','jquery','$tool','$api'],function() {
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer,
        element = layui.element;
        $ = layui.jquery;
        $tool = layui.$tool,
        $api = layui.$api;
        table = layui.table;
    var msgData = [];
    var num = 0;
    var dataVideoCode = [];
    var dataPeopleNum = [];
    //上次登录时间【此处应该从接口获取，实际使用中请自行更换】
    $(".loginTime").html(newDate.split("日")[0] + "日</br>" + newDate.split("日")[1]);
    //icon动画
    $(".panel a").hover(function () {
        $(this).find(".layui-anim").addClass("layui-anim-scaleSpring");
    }, function () {
        $(this).find(".layui-anim").removeClass("layui-anim-scaleSpring");
    })
    $(".panel a").click(function () {
        parent.addTab($(this));
    })

    // //系统基本参数
    // if (window.sessionStorage.getItem("systemParameter")) {
    //     var systemParameter = JSON.parse(window.sessionStorage.getItem("systemParameter"));
    //     fillParameter(systemParameter);
    // } else {
    //     $.ajax({
    //         url: "../../json/systemParameter.json",
    //         type: "get",
    //         dataType: "json",
    //         success: function (data) {
    //             fillParameter(data);
    //         }
    //     })
    // }

    //填充数据方法
    function fillParameter(data) {
        //判断字段数据是否存在
        function nullData(data) {
            if (data == '' || data == "undefined") {
                return "未定义";
            } else {
                return data;
            }
        }

        // $(".version").text(nullData(data.version));      //当前版本
        // $(".author").text(nullData(data.author));        //开发作者
        // $(".homePage").text(nullData(data.homePage));    //网站首页
        // $(".server").text(nullData(data.server));        //服务器环境
        // $(".dataBase").text(nullData(data.dataBase));    //数据库版本
        // $(".maxUpload").text(nullData(data.maxUpload));    //最大上传限制
        // $(".userRights").text(nullData(data.userRights));//当前用户权限
    }

    //TODO：预警信息滚动效果
    function refresh_warn_msg_roll() {

        $.get("../../sysJson/warnMsg_selectAllWarnMessage.action", {
            page: 1,
            limit: 1000
        }, function (data) {
            if (data.code === 0) {
                var hotNewsHtml = '';
                // var hotNewsHtml = '<tr><th>预警信息</th><th>预警位置</th><th>人员数量</th><th>摄像头编号</th><th>预警经纬度</th><th>预警时间</th></tr>';
                for (var i = 0; i < data.data.length; i++) {
                    hotNewsHtml += '<li style="height: 50px;margin-left: 10px;"><a href="javascript:;">预警信息:' + i + '&nbsp;&nbsp;&nbsp;'
                        + '预警位置：' + data.data[i].positionName + '&nbsp;&nbsp;&nbsp;'
                        + '人员数量：' + data.data[i].peopleNum + '&nbsp;&nbsp;&nbsp;'
                        + '摄像头编号：' + data.data[i].videoCode + '  '
                        + '预警时间：' + $tool.formatTime(data.data[i].msgTime + '') + '&nbsp;&nbsp;'
                        + '</a></li>';
                }
                $(".warn_info_ul").html(hotNewsHtml);
            } else {
                layer.msg('请求预警信息列表失败')
            }
        });
    }
    //TODO：柱型图
    function refresh_warn_msg_view(){
        $.ajaxSettings.async = false;//关闭异步

        $.get("../../sysJson/warnMsg_selectAllWarnMessage.action",{page:1, limit:1000},function(data) {
            if (data.code === 0) {
                msgData = [];
                dataPeopleNum = [];
                dataVideoCode = [];
                num = data.data.length;
                msgData = data.data;
                for (var i=0;i<8;i++){
                    dataPeopleNum.push(msgData[--num].peopleNum);
                    dataVideoCode.push(msgData[num].videoCode);
                }
            } else {
                layer.msg('请求预警信息列表失败')
            }
        });
        $.ajaxSettings.async = true;//开启异步
    }
    //获取数据
    refresh_warn_msg_roll();
    //获取数据
    refresh_warn_msg_view();

    //滚动效果
    var oInfobox=document.getElementById('infoBox'),
        oHeight=30,//设置间隔滚动高度
        speed=20, //设置速度
        timer01=null; //设置setInterval定时器
        timer02=null; //设置setTimeout定时器

    oInfobox.innerHTML+=oInfobox.innerHTML; //复制一份内容，无缝滚动

    function startMove(){
        oInfobox.scrollTop++;
        timer01=setInterval(scrollUp,speed);
    }
    function scrollUp(){
        if(oInfobox.scrollTop%oHeight==0){
            clearInterval(timer01);
            timer02=setTimeout(startMove,1000);
        }else{
            oInfobox.scrollTop++;
            if(oInfobox.scrollTop>=oInfobox.offsetHeight){
                //判断元素的滚动高度大于元素本身的高度时，把滚动高度瞬间拉回
                oInfobox.scrollTop=0;
            }
        }
    }
    startMove();
    oInfobox.onmouseover=function(){
        clearInterval(timer01);
        clearTimeout(timer02);
    }
    oInfobox.onmouseout=function(){
        timer01=setInterval(scrollUp,speed);
    }

    //TODO:右侧栏信息
    var dom = document.getElementById("container");
    var myChart = echarts.init(dom);
    var app = {};
    option = null;
    app.title = '各摄像头人员数量统计';

    function addData(shift) {
        //请求数据
        if (num<=0){
            refresh_warn_msg_view();//轮询一遍刷新数据
            num=msgData.length;
            return;
        }
            dataPeopleNum.push(msgData[--num].peopleNum);
            dataVideoCode.push(msgData[num].videoCode);

        if (shift) {
            dataVideoCode.shift();
            dataPeopleNum.shift();
        }
    }
    option = {

        color: ['#009688'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        grid: {
            left: '1%',
            right: '7%',
            bottom: '3%',
            containLabel: true
        },
        xAxis : [
            {
                name : '摄像头',
                type : 'category',
                data : dataVideoCode,
                axisTick: {
                    alignWithLabel: true
                }
            }
        ],
        yAxis : [
            {
                name : '人头数',
                type : 'value'
            }
        ],
        series : [
            {
                name:'摄像头',
                type:'bar',
                barWidth: '50%',
                data:dataPeopleNum
            }
        ]
    };
    setInterval(function () {

        addData(true);
        myChart.setOption({
            xAxis: {
                name: '摄像头编号',
                data: dataVideoCode
            },
            series: [{
                name:'人头数量',
                data: dataPeopleNum
            }]
        });
    }, 3000);;
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }

    //定时
    $(document).ready(function(){
        //循环执行，每隔1秒钟执行一次 1000
        var t1=window.setInterval(refreshCount, 10000);
        function refreshCount() {
            refresh_warn_msg_roll();
        }
        //去掉定时器的方法
        // window.clearInterval(t1);
    });
})
