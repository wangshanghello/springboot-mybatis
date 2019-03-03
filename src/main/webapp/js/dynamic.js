/* 围护墙顶 */
//解决highcharts图表时间与本地时间不匹配
Highcharts.setOptions({global: {useUTC: false}});
var chart = Highcharts.chart('container', {

    chart: {
        type: 'spline',
        animation: Highcharts.svg,
        marginRight: 10,
        backgroundColor: 'rgba(0,0,0,0)',
        events: {
            load: function () {
                //设置更新
                var series = this.series[0];
                var _this = this
                setInterval(function () {
                    var this_ = _this
                    $.ajax({
                        url: "findRetaining",
                        type: "post",
                        dataType: "json",
                        success: function (data) {
                            var addLength = 0;
                            if (this_.series.length < data.length) {
                                addLength += data.length - this_.series.length
                            }

                            for (var i = 0; i < addLength; i++) {
                                for (var i = 0; i < data.length; i++) {
                                    this_.addSeries({

                                        name: data[i].rename,
                                        data: (function () {
                                            var data = [],
                                                time = (new Date()).getTime(),
                                                i;
                                            for (i = -99; i <= 0; i += 1) {
                                                data.push({
                                                    x: time + i * 1000,
                                                });

                                            }
                                            return data;
                                        }())
                                    })
                                }
                            }

                            for (var i = 0; i < data.length; i++) {
                                x = (new Date()).getTime();// 当前时间
                                y = parseFloat(data[i].revalue)
                                this_.series[i].addPoint([x, y], true, true);

                            }
                        }
                    });
                }, 3000);

            }
        }
    },
    lang: {
        noData: "没有数据"
    },
    credits: {
        enabled: false
    },
    time: {
        useUTC: false
    },
    title: {
        text: ''
    },
    xAxis: {
        type: 'datetime',
        tickPixelInterval: 100,
        labels: {
            //  y: 20, //x轴刻度往下移动20px
            style: {
                color: '#fff',//颜色
            }
        }
    },
    yAxis: {
        title: {
            text: ''
        },
        plotLines: [{
            value: 0,
            width: 1
        }],
        labels: {
            formatter: function () {
                return this.value
            },
            style: {
                color: '#fff'
            }
        }
    }, tooltip: {
        formatter: function () {
            return '<b>' + this.series.name + '</b><br/>' +
                Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
                Highcharts.numberFormat(this.y, 2);
        }
    },
    legend: {
        //enabled : false,
        layout: 'vertical',
        align: 'left',
        verticalAlign: 'top',
        //              y: 130,
        borderWidth: 0,
        // 鼠标放上样式
        itemHoverStyle: {
            color: '#fff'
        }, itemStyle: {
            color: '#fff'
        }
        //设置图例不可见
    },
    exporting: {
        enabled: false
    }

});

function baojing() {
    /*  报警 */
    var alaname = new Array();
    var alavalue = new Array();
    $.ajax({
        type: "post",
        url: "findalarm",    //向后端请求数据的url
        data: {},
        success: function (data) {
            for (var x in data) {
                // alert(data[x].alaname+","+data[x].alavalue)
                alaname.push(data[x].alaname)
                alavalue.push(data[x].alavalue)
            }
            var dom = document.getElementById("baojing");
            var myChart = echarts.init(dom);
            var appcolor = new Array();

            option = null;
            var normal = '';
            for (var i in alavalue) {
                if (alavalue[i] >= 60) {
                    normal = '#F2412F';
                    appcolor.push(normal)

                } else {
                    normal = '#25AE4F';
                    appcolor.push(normal)

                }

            }
            var seriesArr = [
                ['amount', 'product'],
            ]
            for (var i = 0; i < alavalue.length; i++) {
                seriesArr.push([alavalue[i], alaname[i]])
            }

            var option = {
                dataset: {
                    source: seriesArr
                },
                grid: {containLabel: true},
                xAxis: {
                    name: 'amount',
                    axisLabel: {
                        show: true,
                        textStyle: {
                            color: '#fff'
                        }
                    }
                },
                yAxis: {
                    type: 'category',
                    axisLabel: {
                        show: true,
                        textStyle: {
                            color: '#fff'
                        }
                    }
                }, title: {
                    text: '',
                    subtext: '',
                    x: 'center'
                },
                tooltip: {
                    trigger: 'item',
                    formatter: "{b} : {c}"
                },
                series: [
                    {
                        type: 'bar',
                        encode: {
                            // Map the "amount" column to X axis.
                            x: 'amount',
                            // Map the "product" column to Y axis
                            y: 'product'
                        },
                        itemStyle: {
                            normal: {
                                color: function (params) {
                                    var colorList = appcolor;
                                    return colorList[params.dataIndex]
                                },

                            }
                        }
                    }
                ]
            };
            if (option && typeof option === "object") {
                myChart.setOption(option, true);
            }

        }

    });
}

/* 仪表 */

/*
var dom = document.getElementById("yibiao");
var myChart = echarts.init(dom);
var app = {};
var option = null;
option = {
    tooltip: {
        formatter: "{a} <br/>{b} : {c}%"
    },
    toolbox: {
        feature: {
            restore: {},
            saveAsImage: {}
        }
    },
    series: [
        {
            name: '业务指标',
            type: 'gauge',
            detail: {formatter: '{value}%'},
            data: [{value: 50, name: '完成率'}]
        }
    ]
};

setInterval(function () {
    option.series[0].data[0].value = (Math.random() * 100).toFixed(2) - 0;
    myChart.setOption(option, true);
}, 2000);
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}*/
