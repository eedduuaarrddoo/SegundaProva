package prova.example.segundaprova.fragments.listar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.view.*
import prova.example.segundaprova.R
import prova.example.segundaprova.model.IgrejaVm

class HomeFragment : Fragment() {
 private lateinit var uIgrejaVm: IgrejaVm
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)

        val adapter=ListAdapter()
        val recyclerView=view.recyclerView
        recyclerView.adapter=adapter
        recyclerView.layoutManager= LinearLayoutManager(requireContext())

        uIgrejaVm=ViewModelProvider(this).get(IgrejaVm::class.java)
        uIgrejaVm.readAllData.observe(viewLifecycleOwner, Observer { igreja ->
            adapter.setData((igreja))
        })
        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_cadastroFragment)
        }
        return view
    }

}