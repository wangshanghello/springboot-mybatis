$(function () {
    $(".highcharts-credits").html("");
})

function renderLayer03Right() {
    $.ajax({
        type: "post",
        url: "findQuality",    //向后端请求数据的url
        data: {},
        success: function (data) {
            for (var x in data) {
                //   alert(data[x].quaname+","+data[x].maxvalue)
                drawLayer03Right($("#layer03_right_chart01 canvas").get(0), "#25AE4F", data[x].maxvalue);
                if (data[x].alarmvalue >= 0.6) {
                    drawLayer03Right($("#layer03_right_chart02 canvas").get(0), "#F2412F", data[x].alarmvalue);
                } else {
                    drawLayer03Right($("#layer03_right_chart02 canvas").get(0), "#25AE4F", data[x].alarmvalue);
                }

                drawLayer03Right($("#layer03_right_chart03 canvas").get(0), "#238681", data[x].maxrate);

                $("#maxvalue").html((data[x].maxvalue * 100) + "mm");
                $("#maxbj").html((data[x].alarmvalue * 100) + "mm");
                $("#maxsl").html((data[x].maxrate * 100) + "mm/d");
            }
        }
    });
}

function drawLayer03Right(canvasObj, colorValue, rate) {

    var ctx = canvasObj.getContext("2d");

    var circle = {
        x: 65,    //圆心的x轴坐标值
        y: 80,    //圆心的y轴坐标值
        r: 60      //圆的半径
    };

    //画扇形
    //ctx.sector(circle.x,circle.y,circle.r,1.5*Math.PI,(1.5+rate*2)*Math.PI);
    //ctx.fillStyle = colorValue;
    //ctx.fill();

    ctx.beginPath();
    if (rate <= 0) {
        ctx.arc(circle.x, circle.y, circle.r, 0, Math.PI * 2, true)
    } else {
        ctx.arc(circle.x, circle.y, circle.r, 0, Math.PI * 2)
    }
    ctx.lineWidth = 10;
    ctx.strokeStyle = '#052639';
    ctx.stroke();
    ctx.closePath();

    ctx.beginPath();
    if (rate <= 0) {
        //规定应该逆时针还是顺时针绘图。False = 顺时针，true = 逆时针。
        ctx.arc(circle.x, circle.y, circle.r, 1.5 * Math.PI, (1.5 + rate * 2) * Math.PI, true)
    } else {
        ctx.arc(circle.x, circle.y, circle.r, 1.5 * Math.PI, (1.5 + rate * 2) * Math.PI)
    }
    ctx.lineWidth = 10;
    ctx.lineCap = 'round';
    ctx.strokeStyle = colorValue;
    ctx.stroke();
    ctx.closePath();

    ctx.fillStyle = 'white';
    ctx.font = '20px Calibri';
    // ctx.fillText(rate * 100 + 'mm', circle.x - 15, circle.y + 10);

}

//饼状图
function renderChartBar01() {

    var myChart = echarts.init(document.getElementById("layer03_left_02"));
    var app = {};
    option = null;
    option = {
        title: {
            text: '',
            subtext: '',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            x: 'left',
            data: [],
            inactiveColor: '#999',
            width: 70,
            top: 85,

            textStyle: {
                color: '#fff',
                fontSize: 10
            },
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {
                    show: true,
                    type: ['pie', 'funnel'],
                    option: {
                        funnel: {
                            x: '25%',
                            width: '50%',
                            funnelAlign: 'left',
                            max: 1548
                        }
                    }
                },
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        series: [
            {
                name: '',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: []
            }
        ]
    };
    ;
    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
//饼图动态赋值
    $.ajax({
        type: "get",
        url: "findProject",
        data: {},
        cache: false,    //禁用缓存
        dataType: "json",
        success: function (result) {
            var names = [];//定义两个数组
            var nums = [];
            $.each(result, function (key, values) { //此处我返回的是list<String,map<String,String>>循环map
                names.push(values.name);
                var obj = new Object();
                obj.name = values.name;
                obj.value = values.value;
                nums.push(obj);
            });
            myChart.setOption({ //加载数据图表
                legend: {
                    data: []//names
                },
                series: {
                    // 根据名字对应到相应的系列
                    name: [],
                    data: nums
                }
            });
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("查询失败");
        }
    })

}

function get10MinutesScale() {
    var currDate = new Date();
    var odd = currDate.getMinutes() % 10;
    var returnArr = new Array();
    currDate.setMinutes(currDate.getMinutes() - odd);
    for (var i = 0; i < 7; i++) {
        returnArr.push(currDate.getHours() + ":" + (currDate.getMinutes() < 10 ? ("0" + currDate.getMinutes()) : currDate.getMinutes()));
        currDate.setMinutes(currDate.getMinutes() - 10);
    }
    return returnArr;
}


function getLatestDays(num) {
    var currentDay = new Date();
    var returnDays = [];
    for (var i = 0; i < num; i++) {
        currentDay.setDate(currentDay.getDate() - 1);
        returnDays.push((currentDay.getMonth() + 1) + "/" + currentDay.getDate());
    }
    return returnDays;
}

function loadTwoLine() {
    var myChart = echarts.init(document.getElementById('layer04_right_chart'));
    // 显示标题，图例和空的坐标轴
    myChart.setOption({
        title: {
            text: ''
        },
        tooltip: {
            trigger: 'axis'
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: false},
                dataView: {show: false, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: false},
                saveAsImage: {show: false}
            }
        },
        calculable: true,
        xAxis: {
            type: 'category',
            boundaryGap: false, //取消左侧的间距
            data: []
        },
        yAxis: {
            type: 'value',
            splitLine: {show: false},//去除网格线
            name: '',
            axisLabel: {
                show: true,
                textStyle: {
                    color: '#fff'
                }
            }
        },
        series: [{
            name: '',
            type: 'line',
            symbol: 'emptydiamond',    //设置折线图中表示每个坐标点的符号 emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
            data: []
        },
            {
                name: '',
                type: 'line',
                symbol: 'emptydiamond',    //设置折线图中表示每个坐标点的符号 emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
                data: []
            },
            {
                name: '',
                type: 'line',
                symbol: 'emptydiamond',    //设置折线图中表示每个坐标点的符号 emptycircle：空心圆；emptyrect：空心矩形；circle：实心圆；emptydiamond：菱形
                data: []
            }]
    });
    //  myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画
    var names = [];    //类别数组（实际用来盛放X轴坐标值）
    var series1 = [];
    var series2 = [];
    var series3 = [];
    var times = [];
    $.ajax({
        type: 'get',
        url: 'finddemo',//请求数据的地址
        dataType: "json",        //返回数据形式为json
        success: function (result) {
            //请求成功时执行该函数内容，result即为服务器返回的json对象
            $.each(result.sameResult, function (index, item) {
                names.push(item.rename);    //挨个取出类别并填入类别数组
                series1.push(item.revalue);
            });
            $.each(result.yesterResult, function (index, item) {
                series2.push(item.revalue);
            });
            $.each(result.beforeResult, function (index, item) {
                series3.push(item.revalue);
            });
            $.each(result.timeResult, function (index, item) {
                times.push(item.retime);
            });
            //   myChart.hideLoading();    //隐藏加载动画
            myChart.setOption({        //加载数据图表
                grid: {
                    left: 200
                },
                legend: {
                    x: 'left',
                    data: times,
                    inactiveColor: '#999',
                    width: 70,
                    top: 50,
                    textStyle: {
                        color: '#fff',
                        fontSize: 10
                    }
                },
                xAxis: {
                    show: true,
                    data: times,
                    axisLabel: {
                        show: true,
                        textStyle: {
                            color: '#fff',
                            fontSize: 10
                        }
                    }

                },
                series: [{
                    name: times[0],
                    data: series3
                },
                    {
                        name: times[1],
                        data: series2
                    },
                    {
                        name: times[2],
                        data: series1
                    }]
            });
        },
        error: function (errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    });
};
loadTwoLine();