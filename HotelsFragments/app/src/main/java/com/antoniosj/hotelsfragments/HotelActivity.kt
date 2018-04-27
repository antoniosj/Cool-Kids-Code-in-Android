package com.antoniosj.hotelsfragments

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.antoniosj.hotelsfragments.HotelDetailFragment.Companion.EXTRA_HOTEL

class HotelActivity : AppCompatActivity(), HotelListFragment.onHotelClick {
    override fun hotelClick(hotel: Hotel) {
        val it = Intent(this, HotelDetailActivity::class.java)
        it.putExtra(EXTRA_HOTEL, hotel)
        startActivity(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel)
    }
}
