package screen

import extensions.getNotEmptyString

/*
실습 4
1. 장바구니에 추가한 상품 관리
2. 사용자 입력값 요청 처리 공통화
3. 프로젝트 전역에서 참조하는 상수
 */

class ShoppingCategory : Screen() {
    fun showCategories() {
        ScreenStack.push(this)
        /*
        실습 2
        1. 상품 카테고리 표기
        2. 사용자 입력 받기
        3. 사용자가 기대하는 값을 입력하지 않는 경우에 대한 처리
        */
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }
        println("=> 장바구니로 이동하시려면 #을 입력해주세요.")

        var selectedCategory = readLine().getNotEmptyString()
/*
        while (selectedCategory.isNullOrBlank()) {
            println("값을 입력해주세요")
            selectedCategory = readLine()
        }

 */ //.getNotEmptyString()으로 대체
       if (selectedCategory == "#") {
            //장바구니 이동
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItems()
        } else {
            if (categories.contains(selectedCategory)) {
                //카테고리 상품 목록 보여주기
                val shoppingProductList = ShoppingProductList(selectedCategory)
                shoppingProductList.showProducts()
            } else {
                showErrorMassage(selectedCategory)
            }
        }
    }

    private fun showErrorMassage(selectedCategory: String?) {
        //카테고리 목록에 없는 값을 입력하는 경우
        println("[$selectedCategory] : 존재하지 않는 카테고리 입니다. 다시 입력해주세요")
        showCategories()
    }
}