

function loadComments(endpoint) {
    fetch(endpoint).then(function(res) {
        return res.json();
    }).then(function(data) {
        let c = document.getElementById("comments");
        let h = '';
        for (let d of data) 
            h += `
        
            <div class="row d-flex justify-content-center">
                <div class="d-flex flex-start mb-4">
                    <img src="${d.userCommentId.avatar}" class="rounded-circle shadow-1-strong me-3 rounded-circle img-fluid" 
                        alt="avatar" width="65" height="65"/>
                    
                </div>
                
                <div class="card w-100">
                    <h5>${d.userCommentId.username}</h5>
        
                    <p class="small">${moment(d.createdDate).locale("vi").fromNow()}</p>
                    <div class="card-body p-4"><em>${d.content}</em>
                    </div> 
                </div> 
            </div>
        
            `;
        c.innerHTML = h;
    });
}

function addComment(endpoint, recId) {
    event.prevenDefault()
    fetch(endpoint, {
        method: "post",
        body: JSON.stringify({
            "content": document.getElementById("contentId").value,
            "recruitmentId": recId
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.querySelector("#comment li:first-child");
        let h = `
                <li class="list-group-item"><em>${data.content}</em>  <strong>${data.userCommentId.username}</strong> vao luc <strong>${moment(data.createdDate).locale("vi").fromNow()}</strong></li>
            `;
        d.insertAdjacentHTML("beforebegin", h);
    });
}

function addToCart(){
    fetch("/AnhTuan1/api/cart", {
        method: 'post',
        body: JSON.stringify({
            "recruitmentId": id,
            "recruitmentName":name,
            "price":price,
            "quatity":quatity
        }),
        header:{
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("cartCounter");
        counter.innerText = data
    })
}

