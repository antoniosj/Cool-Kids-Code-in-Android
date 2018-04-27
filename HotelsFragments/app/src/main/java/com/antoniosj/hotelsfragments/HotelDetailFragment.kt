package com.antoniosj.hotelsfragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView

/**
 * Created by antonio on 17/04/2018.
 */
class HotelDetailFragment : Fragment() {

    lateinit var textName: TextView
    lateinit var textAddress: TextView
    lateinit var ratingStars: RatingBar
    lateinit var hotel: Hotel

    companion object {
        const val TAG_DETAIL = "tagDetail"
        const val EXTRA_HOTEL = "hotel"

        fun newInstance(hotel: Hotel): HotelDetailFragment {
            val params = Bundle()
            params.putSerializable(EXTRA_HOTEL, hotel)
            var fragment = HotelDetailFragment()
            fragment.arguments = params
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hotel = arguments.getSerializable(EXTRA_HOTEL) as Hotel
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var layout = inflater?.inflate(R.layout.fragment_detail_hotel, container, false)
        textName = layout!!.findViewById(R.id.txtName)
        textAddress = layout.findViewById(R.id.txtAddress)
        ratingStars = layout.findViewById(R.id.rtbStars)

        textName.text = hotel.name
        textAddress.text = hotel.address
        ratingStars.rating = hotel.star

        return layout
    }

}