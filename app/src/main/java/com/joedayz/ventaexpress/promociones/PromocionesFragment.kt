package com.joedayz.ventaexpress.promociones

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.joedayz.ventaexpress.R

class PromocionesFragment :Fragment(){



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("PromocionesFragment", "onCreateView")
        return inflater.inflate(R.layout.fragment_promociones, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("PromocionesFragment", "onViewCreated")
    }
}