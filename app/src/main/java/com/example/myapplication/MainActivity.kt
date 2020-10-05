package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.fragment.FirstFragment
import com.example.myapplication.fragment.SecondFragment
import com.example.myapplication.fragment.ThirdFragment

class MainActivity : AppCompatActivity() {
    //데이터 바인딩해준다.
    private lateinit var binding: ActivityMainBinding
    //각각의 프레그먼트 불러옴
    private val firstFragment = FirstFragment()
    private val secondFragment = SecondFragment()
    private  val thirdFragment = ThirdFragment()

    //앱생성
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        setListener()
        showFragment(firstFragment)
    }
    //메뉴물러온다
    private fun setListener() {
        binding.bottomNav.setOnNavigationItemSelectedListener {

            val fragment = getFragmentById(it.itemId)
            showFragment(fragment)

            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun getFragmentById(id:Int): Fragment =
        //자바의 스위치문
        when(id){
            R.id.first -> {
                firstFragment
            }
            R.id.second ->{
                secondFragment
            }
            R.id.third ->{
                thirdFragment
            }
            else -> firstFragment
        }

    private fun showFragment(fragment:Fragment) {
        supportFragmentManager.beginTransaction().replace(binding.frame.id,fragment).commit()

    }
}