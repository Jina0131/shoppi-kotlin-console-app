import screen.ShoppingHome

fun main(args: Array<String>) { //fun: 함수 정의
    /*
    실습 3
    1. main->class 함수
    2. 화면별 클래스 분리
    3. 선택한 카테고리 상품 목록 표시
     */
    val shoppingHome = ShoppingHome()
    shoppingHome.start()
}