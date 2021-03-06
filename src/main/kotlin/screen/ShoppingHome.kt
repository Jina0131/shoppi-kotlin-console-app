package screen

import LINE_DIVIDER
import extensions.getNotEmptyString

/*
1. 화면이동을 관리하는 Stack
2. 장바구니 이전화면 이동 구현
 */

class ShoppingHome : Screen() {

    fun start() {
        showWelcomeMassage()
        showCategories()
    }

    private fun showCategories() {
        val shoppingCategory = ShoppingCategory()
        shoppingCategory.showCategories()
    }

    private fun showWelcomeMassage() {
        ScreenStack.push(this)
        /*
        실습 1
        1. 인사말 출력
        2. 사용자 이름 받기
        3. 입력 받은 사용자 이름 출력
         */
        println("안녕하세요. Shoppi 에 오신 것을 환영합니다!") //print: 이어서 출력, println: 한 줄 띄어 출력
        println("쇼핑을 계속 하시려면 이름을 입력해주세요 :)")

        val name = readLine().getNotEmptyString()

        println(
            """
            감사합니다. 반갑습니다, $name 님
            원하시는 카테고리를 입력해주세요.
            $LINE_DIVIDER
        """.trimIndent()
        )
    }
}