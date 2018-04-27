package com.antoniosj.hotelsfragments

import android.app.ListFragment
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView


class HotelListFragment : ListFragment() {
    lateinit var hotels: List<Hotel>
    lateinit var adapter: ArrayAdapter<Hotel>

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        hotels = loadHotels()

        adapter = ArrayAdapter<Hotel>(activity, android.R.layout.simple_list_item_1, hotels)
        listAdapter = adapter

    }

    override fun onListItemClick(l: ListView?, v: View?, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)
        val activity = activity
        if (activity is onHotelClick) {
            val hotel = l?.getItemAtPosition(position) as Hotel
            val listener = activity as onHotelClick
            listener.hotelClick(hotel)
        }
    }

    private fun loadHotels() : List<Hotel> {
        var hotels = ArrayList<Hotel>()
        hotels.add(Hotel("New Beach Hotel", "Av. Boa Viagem", 4.5f))
        hotels.add(Hotel("Recife Hotel", "Av. Boa Viagem", 4.0f))
        hotels.add(Hotel("Canario Hotel", "Rua dos Navegantes", 3.0f))
        hotels.add(Hotel("Byanca Beach Hotel", "Rua Mamanguape", 4.0f))
        hotels.add(Hotel("Hotel Cool", "Av. Cons Aguiar", 5.0f))
        hotels.add(Hotel("Infinito Hotel", "Av. Boa Viagem", 4.5f))
        return hotels
    }

    interface onHotelClick {
        fun hotelClick(hotel: Hotel)
    }

}