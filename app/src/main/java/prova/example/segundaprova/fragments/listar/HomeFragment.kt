package prova.example.segundaprova.fragments.listar

import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.view.*
import prova.example.segundaprova.MainViewModelFActory
import prova.example.segundaprova.R
import prova.example.segundaprova.api.Repository
import prova.example.segundaprova.model.IgrejaVm
import prova.example.segundaprova.utils.NetworkChecker

class HomeFragment : Fragment() {
    private lateinit var viewModel: listarVM
    private lateinit var uIgrejaVm: IgrejaVm

    private val networkChecker by lazy {
        NetworkChecker(getSystemService(requireContext(), ConnectivityManager::class.java))
    }
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
//        uIgrejaVm.readAllData.observe(viewLifecycleOwner, Observer { igreja ->
//            adapter.setData((igreja))
//        })
        view.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_cadastroFragment)
        }




val repository = Repository()
 val viewModelFactory= MainViewModelFActory(repository)
    viewModel = ViewModelProvider(this, viewModelFactory).get(listarVM::class.java)
    viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            for (i in 0 until response.size ) {
                Log.i("RESPONSE", "${response[i].id}")
                Log.i("RESPONSE", "${response[i].nome}")
                Log.i("RESPONSE", "${response[i].profeta}")
                Log.i("RESPONSE", "${response[i].numfieis}")
                Log.i("RESPONSE", "${response[i].descricao}")

            }



        })

        networkChecker.performActionIfConnectc {
            val adapterPost = PostAdapter()
            recyclerView.adapter = adapterPost


            viewModel.myResponse.observe(this, Observer { response ->

              adapterPost.setDataRemote(response)



                for (i in 0 until response.size ) {
                    Log.i("RESPONSE", "${response[i].id}")
                    Log.i("RESPONSE", "${response[i].nome}")
                    Log.i("RESPONSE", "${response[i].profeta}")
                    Log.i("RESPONSE", "${response[i].numfieis}")
                    Log.i("RESPONSE", "${response[i].descricao}")

                }



            })

        }

        return view
    }


}