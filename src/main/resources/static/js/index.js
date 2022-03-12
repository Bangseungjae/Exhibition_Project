var main = {
    init : function () {
        console.log("init")
        var _this = this;
        document.querySelector("#btn-save").addEventListener('click', this.save);

        // $('#btn-update').on('click', function () {
        //     _this.update();
        // });
        //
        document.querySelector("#btn-delete").addEventListener('click', this.delete);
    },
    save : function () {
        console.log("save-function");
        console.log(document.querySelector("#title").value);
        let data = {
            title: document.querySelector("#title").value,
            period: document.querySelector("#period").value,
            url: document.querySelector("#url").value,
        };
        let id = {
            id: document.querySelector("#id").value,
        }
        console.log("data = " + JSON.stringify(data));
        console.log("id = " + String(id.id));

        $.ajax({
            type: 'POST',
            url: '/api/user/reservations/'+String(id.id),
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('전시회가 등록되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete : function () {
        console.log("delete-function");
        console.log(document.querySelector("#d-title").value);
        let data = {
            id: document.querySelector("#d-id").value,
            title: document.querySelector("#d-title").value,
            period: document.querySelector("#d-period").value,
            url: document.querySelector("#d-url").value,
        };
        console.log("reservation id = "+ String(data.id));

        let id = {
            id: document.querySelector("#id").value,
        }
        console.log("data = " + JSON.stringify(data));
        console.log("id = " + String(id.id));

        $.ajax({
            type: 'DELETE',
            url: '/api/user/'+String(id.id),
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('찜을 삭제했습니다.');
            location.reload();
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
};

main.init();