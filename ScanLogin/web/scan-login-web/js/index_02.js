new Vue({
    el: '#app',
    data: {
        code: '',
        info: '',
        t1: null,
        t2: null,
        state: 0
    },
    methods: {
        //获取扫描识别码
        getScanCode() {
            this.$http.get('http://192.168.0.100:7021/api/user/getScanCodeStream')
                .then(
                    function (response) {
                        var that = this;
                        //响应成功回调
                        var result = response
                        //清空二维码画布 否则会保留原来的
                        //$('#output').children('*').remove();
                        //$('#output').empty();
                        //$('#output').qrcode(this.code);

                        //$('#qr').attr("src","data:image/jpeg;base64,"+result)
                        //$('#qr').attr("src","data:image/jpeg;base64,"+result)

                        //var objectURL = URL.createObjectURL(result)
                        //console.log(objectURL)


                        console.log(result)



                        //在此轮询 1秒一次
                        //this.loopAsk()
                    },
                    function (response) {
                        //响应错误回调
                        alert('有错误')
                    }
                );
        },
        //轮询
        loopAsk() {
            var that = this
            that.t1 = setInterval(function () {
                that.t2 = setTimeout(function () {
                    //console.log('this.state')
                    that.askLoginInfo()
                }, 1000)
            }, 1000)
        },
        //查询登录信息
        askLoginInfo() {
            console.log('askLoginInfo')
            this.$http.get('http://192.168.0.100:7021/api/user/askLogin', {params: {code: this.code}})
                .then(
                    function (response) {
                        var name = response.data.username
                        console.log(name)
                        if (name == null) {
                            console.log('unkown')
                        } else {
                            var i = name + " 成功登录"
                            console.log(i)
                            this.info = i
                            clearInterval(this.t1)
                            clearInterval(this.t2)
                            $('#output').empty();
                        }
                    },
                    function (response) {
                        alert('有错误')
                    }
                );
        }

    }
});