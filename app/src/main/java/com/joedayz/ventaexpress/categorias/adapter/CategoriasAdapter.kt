package com.joedayz.ventaexpress.categorias.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joedayz.ventaexpress.R
import com.joedayz.ventaexpress.categorias.adapter.holder.CategoriasHolder
import com.joedayz.ventaexpress.categorias.modelo.Categorias

class CategoriasAdapter() : RecyclerView.Adapter<CategoriasHolder>() {

    private var categoriasLista = mutableListOf<Categorias>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriasHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_categorias, parent, false)
        return CategoriasHolder(itemView)
    }

    override fun getItemCount(): Int {
        return categoriasLista.size
    }

    override fun onBindViewHolder(holder: CategoriasHolder, position: Int) {
        val categorias = categoriasLista.get(position);
        holder.bind(categorias)
    }

    fun actualizarLista(categoriasLista: MutableList<Categorias>) {
        this.categoriasLista.clear()
        this.categoriasLista.addAll(categoriasLista)
        notifyDataSetChanged()
    }

}