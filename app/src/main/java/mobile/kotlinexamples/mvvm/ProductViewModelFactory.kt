package mobile.kotlinexamples.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class ProductViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductViewModel::class.java)) {
            return ProductViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}