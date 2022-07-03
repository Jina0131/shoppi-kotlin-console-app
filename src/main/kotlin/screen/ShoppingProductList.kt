package screen

import LINE_DIVIDER
import data.CartItems
import data.Product
import extensions.getNotEmptyInt
import extensions.getNotEmptyString

class ShoppingProductList : Screen() {
    //카테고리 상품 목록 보여주기
    private val products = arrayOf(
        Product(categoryLabel = "패션", name =  "겨울 패딩"),
        Product(categoryLabel = "패션", name = "겨울 바지"),
        Product(categoryLabel = "전자기기", name = "핸드폰"),
        Product(categoryLabel = "전자기기", name = "블루투스 이어폰"),
        Product(categoryLabel = "전자기기", name = "노트북"),
        Product(categoryLabel = "반려동물용품", name = "건식사료"),
        Product(categoryLabel = "반려동물용품", name = "습식사료"),
        Product(categoryLabel = "반려동물용품", name = "치약"),
        Product(categoryLabel = "반려동물용품", name = "간식")
    )
    private val categories: Map<String, List<Product>> = products.groupBy{ product ->
        product.categoryLabel
    }
    fun showProducts(selectedCategory: String) {
        ScreenStack.push(this)
        val categoryProducts = categories[selectedCategory]
        if (!categoryProducts.isNullOrEmpty()) {
            println("""
                $LINE_DIVIDER
                선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent())
            /*
            val productSize = categoryProducts.size
            for (index in 0 until productSize) {
                println("${index}.${categoryProducts[index].name}")
            }
             */ // 아래 코드로 대체 가능
            categoryProducts.forEachIndexed { index, product ->
                println("${index}. ${product.name}")
            }
            showCartOption(categoryProducts, selectedCategory)
        } else {
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showCartOption(categoryProducts: List<Product>, selectedCategory: String) {
        println(
            """
                    $LINE_DIVIDER
                    장바구니에 담을 상품 번호를 선택해주세요.
                """.trimIndent()
        )
        
        val selectedIndex = readLine().getNotEmptyInt()
        categoryProducts.getOrNull(selectedIndex)?.let { product ->
            CartItems.addProduct(product)
            println("=> 장바구니로 이동하시려면 #을, 계속 쇼핑하시려면 *을 입력해주세요.")
            val answer = readLine().getNotEmptyString()
            if (answer == "#") {
                val shoppingCart = ShoppingCart()
                shoppingCart.showCartItems()
            } else if (answer == "*") {
                showProducts(selectedCategory)
            } else {
                //TODO 그 외 값을 입력한 경우에 대한 처리
            }
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리의 상품이 등록되기 전입니다.")
    }
}