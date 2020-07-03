package com.joedayz.ventaexpress.categorias.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.joedayz.ventaexpress.categorias.modelo.Categorias
import kotlinx.android.synthetic.main.item_categorias.view.*

class CategoriasHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(categorias: Categorias) {

        itemView.textViewNombreCategoria.textViewNombreCategoria.setText(categorias.nombreCategoria)
    }

}