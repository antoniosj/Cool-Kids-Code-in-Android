package com.antoniosj.hotelsfragments

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.antoniosj.hotelsfragments.HotelDetailFragment.Companion.EXTRA_HOTEL

class HotelDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hotel_detail)

        if (savedInstanceState == null) {
            val intent = intent
            var hotel = intent.getSerializableExtra(EXTRA_HOTEL) as Hotel
            val fragment = HotelDetailFragment.newInstance(hotel)
            val fm = supportFragmentManager
            fm.beginTransaction().replace(R.id.detail, fragment, HotelDetailFragment.TAG_DETAIL).commit()
        }
    }
}
