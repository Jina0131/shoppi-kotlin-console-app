package screen

import data.Product

class ShoppingProductList {
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
        val categoryProducts = categories[selectedCategory]
        if (!categoryProducts.isNullOrEmpty()) {
            println("""
                ***==============================================
                선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent())
            val productSize = categoryProducts.size
            for (index in 0 until productSize) {
                println("${index}.${categoryProducts[index].name}")
            }
        } else {
            showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리의 상품이 등록되기 전입니다.")
    }
}