function addToCart(bookid){
    if(confirm("장바구니에 도서를 추가할까요?")){
        document.addForm.action = "/BookMarket/cart/book/" + bookid;
        document.addForm.submit();
    }
}

function removeFromCart(bookid, cartid){
    document.removeForm.action = "/BookMarket/cart/book/" + bookid;
    document.removeForm.submit();
    setTimeout('location.reload()', 10);
}


function deleteCart(cartid){
    if(confirm('모든 도서를 장바구니에서 삭제하시겠습니까?')){
        document.deleteForm.submit();
        setTimeout('location.reload()', 10);
    }
}