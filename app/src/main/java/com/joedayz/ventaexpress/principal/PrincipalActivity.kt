package com.joedayz.ventaexpress.principal

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.joedayz.ventaexpress.R
import com.joedayz.ventaexpress.categorias.CategoriasFragment
import com.joedayz.ventaexpress.productos.ProductosFragment
import com.joedayz.ventaexpress.promociones.PromocionesFragment
import kotlinx.android.synthetic.main.activity_principal.*
import kotlinx.android.synthetic.main.menu_lateral.view.*
import kotlinx.android.synthetic.main.toolbar_main.view.*


class PrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        include_toolbar.botonMenu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        onClickMenuLateral(1)
        menu_lateral.listadoPromociones.setOnClickListener { onClickMenuLateral(1) }
        menu_lateral.listadoCategorias.setOnClickListener { onClickMenuLateral(2) }
        menu_lateral.listadoProductos.setOnClickListener { onClickMenuLateral(3) }
    }

    private fun onClickMenuLateral(tipo: Int) {
        var fragment = Fragment()
        when (tipo) {
            1 -> fragment = PromocionesFragment()
            2 -> fragment = CategoriasFragment()
            3 -> fragment = ProductosFragment()
            else -> Log.i("PrincipalActivity", "onCLickMenuLateral")
        }
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
        closeDrawer()
    }

    private fun closeDrawer() {
        drawerLayout.closeDrawer(GravityCompat.START)
    }


}