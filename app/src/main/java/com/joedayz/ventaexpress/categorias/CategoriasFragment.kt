package com.joedayz.ventaexpress.categorias

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.joedayz.ventaexpress.R
import com.joedayz.ventaexpress.categorias.adapter.CategoriasAdapter
import com.joedayz.ventaexpress.categorias.modelo.Categorias
import kotlinx.android.synthetic.main.fragment_categorias.*

class CategoriasFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_categorias, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFireStore()
        val adapter = CategoriasAdapter()
        recicladorCategorias.adapter = adapter
        recicladorCategorias.layoutManager = GridLayoutManager(requireContext(),2)
        recicladorCategorias.setHasFixedSize(true)
        adapter.actualizarLista(obtenerListaCategoria())
    }

    private fun initFireStore() {


    }

    fun obtenerListaCategoria(): MutableList<Categorias> {
        val mutableListaCategorias = mutableListOf<Categorias>()
        mutableListaCategorias.add(
            Categorias(
                "11111",
                "Telefonía y Comunicaciones",
                "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/50dad8da-ce58-4540-a042-1313d34b7e56/dde1y6i-60031d4a-ff0c-4d32-808b-9c8b78eeb313.jpg/v1/fill/w_1000,h_799,q_70,strp/dragon_ball_super_by_dt501061_dde1y6i-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3siaGVpZ2h0IjoiPD0yODczIiwicGF0aCI6IlwvZlwvNTBkYWQ4ZGEtY2U1OC00NTQwLWEwNDItMTMxM2QzNGI3ZTU2XC9kZGUxeTZpLTYwMDMxZDRhLWZmMGMtNGQzMi04MDhiLTljOGI3OGVlYjMxMy5qcGciLCJ3aWR0aCI6Ijw9MzU5MiJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.u7CsMDKExVukwVE7eYnP04fQJ_4YY80O1FRK0Nd0tQE"
            )
        )
        mutableListaCategorias.add(
            Categorias(
                "11112",
                "Electrónica",
                "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/10522bf5-e042-4fa1-abea-6d563895ee34/ddbop2d-c413e343-cdaa-4561-9a17-7e3c2b075332.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvMTA1MjJiZjUtZTA0Mi00ZmExLWFiZWEtNmQ1NjM4OTVlZTM0XC9kZGJvcDJkLWM0MTNlMzQzLWNkYWEtNDU2MS05YTE3LTdlM2MyYjA3NTMzMi5qcGcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.bIRRfp5r2e-HOqpdbvjqv8mkkbnOXrUdoksxri03dJA"
            )
        )
        mutableListaCategorias.add(
            Categorias(
                "11113",
                "Bisutería y relojes",
                "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/50dad8da-ce58-4540-a042-1313d34b7e56/dd9s4z6-3515d090-6eb1-415e-ba7c-331404caf35e.jpg/v1/fill/w_920,h_868,q_70,strp/dragon_ball_super_by_dt501061_dd9s4z6-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3siaGVpZ2h0IjoiPD0yMzU4IiwicGF0aCI6IlwvZlwvNTBkYWQ4ZGEtY2U1OC00NTQwLWEwNDItMTMxM2QzNGI3ZTU2XC9kZDlzNHo2LTM1MTVkMDkwLTZlYjEtNDE1ZS1iYTdjLTMzMTQwNGNhZjM1ZS5qcGciLCJ3aWR0aCI6Ijw9MjUwMCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.yGSw0patNAw5Ahf_AzA6ErbWItmDatjHfRY3wpTBViM"
            )
        )
        mutableListaCategorias.add(
            Categorias(
                "11114",
                "Informática",
                "https://www.alfabetajuega.com/wp-content/uploads/2019/01/goku-nino-nube-e1546512190734.jpg"
            )
        )
        mutableListaCategorias.add(
            Categorias(
                "11115",
                "Salud y Belleza",
                "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/50dad8da-ce58-4540-a042-1313d34b7e56/dde1y6i-60031d4a-ff0c-4d32-808b-9c8b78eeb313.jpg/v1/fill/w_1000,h_799,q_70,strp/dragon_ball_super_by_dt501061_dde1y6i-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3siaGVpZ2h0IjoiPD0yODczIiwicGF0aCI6IlwvZlwvNTBkYWQ4ZGEtY2U1OC00NTQwLWEwNDItMTMxM2QzNGI3ZTU2XC9kZGUxeTZpLTYwMDMxZDRhLWZmMGMtNGQzMi04MDhiLTljOGI3OGVlYjMxMy5qcGciLCJ3aWR0aCI6Ijw9MzU5MiJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.u7CsMDKExVukwVE7eYnP04fQJ_4YY80O1FRK0Nd0tQE"
            )
        )
        mutableListaCategorias.add(
            Categorias(
                "11116",
                "Deporte y Exterior",
                "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/50dad8da-ce58-4540-a042-1313d34b7e56/dd9s4z6-3515d090-6eb1-415e-ba7c-331404caf35e.jpg/v1/fill/w_920,h_868,q_70,strp/dragon_ball_super_by_dt501061_dd9s4z6-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3siaGVpZ2h0IjoiPD0yMzU4IiwicGF0aCI6IlwvZlwvNTBkYWQ4ZGEtY2U1OC00NTQwLWEwNDItMTMxM2QzNGI3ZTU2XC9kZDlzNHo2LTM1MTVkMDkwLTZlYjEtNDE1ZS1iYTdjLTMzMTQwNGNhZjM1ZS5qcGciLCJ3aWR0aCI6Ijw9MjUwMCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.yGSw0patNAw5Ahf_AzA6ErbWItmDatjHfRY3wpTBViM"
            )
        )
        mutableListaCategorias.add(
            Categorias(
                "11117",
                "Motor",
                "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/50dad8da-ce58-4540-a042-1313d34b7e56/dd9s4z6-3515d090-6eb1-415e-ba7c-331404caf35e.jpg/v1/fill/w_920,h_868,q_70,strp/dragon_ball_super_by_dt501061_dd9s4z6-pre.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3siaGVpZ2h0IjoiPD0yMzU4IiwicGF0aCI6IlwvZlwvNTBkYWQ4ZGEtY2U1OC00NTQwLWEwNDItMTMxM2QzNGI3ZTU2XC9kZDlzNHo2LTM1MTVkMDkwLTZlYjEtNDE1ZS1iYTdjLTMzMTQwNGNhZjM1ZS5qcGciLCJ3aWR0aCI6Ijw9MjUwMCJ9XV0sImF1ZCI6WyJ1cm46c2VydmljZTppbWFnZS5vcGVyYXRpb25zIl19.yGSw0patNAw5Ahf_AzA6ErbWItmDatjHfRY3wpTBViM"
            )
        )
        return mutableListaCategorias
    }
}