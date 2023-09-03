package com.example.lovecalculator.module


import com.example.lovecalculator.Presenter
import com.example.lovecalculator.ui.calculate.CalculateFragment
import com.example.lovecalculator.view.LoveView
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@InstallIn(SingletonComponent::class)
@Module
abstract class InterfaceModule {

    @Binds
    abstract fun bindLoveView(fragment: CalculateFragment): LoveView

}
