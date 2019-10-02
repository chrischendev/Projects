new Vue({
    el: '#app',
    data: {
        code: '',
        name: ''
    },
    methods: {
        getScanCode() {
            this.$http.get('http://192.168.0.100:7021/api/user/getScanCode')
                .then(
                    function (response) {
                        //响应成功回调
                        this.code = response.data.code
                        //清空二维码画布 否则会保留原来的
                        //$('#output').children('*').remove();
                        $('#output').empty();
                        $('#output').qrcode(this.code);

                        //在此轮询 1秒一次
                        this.askLoginInfo(this.code);
                    },
                    function (response) {
                        //响应错误回调
                        alert('有错误')
                    }
                );
        },
        askLoginInfo(code) {
            this.$http.get('http://192.168.0.100:7021/api/user/askLogin')
                .then(
                    function (response) {
                        this.name = response.data.username
                    },
                    function (response) {
                        alert('有错误')
                    }
                );
        }

    }
});