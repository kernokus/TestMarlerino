package com.example.testmarlerino.view
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testmarlerino.R
import com.example.testmarlerino.room.itemCatalogs
import com.example.testmarlerino.viewModel.GameViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main_game.*
import kotlinx.android.synthetic.main.item_catalog.view.*

@AndroidEntryPoint
class MainGameFragment:Fragment() {
    private lateinit var myAdapter :AdapterPendingCases
    private val gameViewModel: GameViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_game,container,false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gameViewModel.loadCatalog()
        val items: ArrayList<itemCatalogs>? = arrayListOf()
        rvCatalog.layoutManager= GridLayoutManager(context,2)
        myAdapter=AdapterPendingCases(items)
        rvCatalog.adapter=myAdapter
        gameViewModel.getCatalog()
        gameViewModel.catalogLD.observe(viewLifecycleOwner, object : Observer<Collection<itemCatalogs>?> {
            override fun onChanged(t: Collection<itemCatalogs>?) {
                if (t!=null) {
                    myAdapter.addList(t as List<itemCatalogs>)
                    Log.d("onChanged",myAdapter.values.toString())
                }
            }
        })
    }



    inner class AdapterPendingCases(var values:ArrayList<itemCatalogs>?): RecyclerView.Adapter<AdapterPendingCases.PendingCasesViewHolder>() {
        override fun getItemCount(): Int {
            return values!!.size
        }
        inner class PendingCasesViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

            fun bind(item: itemCatalogs) {
                Glide.with(gameViewModel.app).load(item.url).into(itemView.photoItem)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PendingCasesViewHolder {
            return PendingCasesViewHolder(LayoutInflater.from(gameViewModel.app).inflate(R.layout.item_catalog, parent, false))}


        override fun onBindViewHolder(holder: PendingCasesViewHolder, position: Int) {
            values?.get(position)?.let { holder.bind(it) }
            holder.itemView.setOnClickListener {
                val bundle1=Bundle()
                val arrayForBundle: ArrayList<String?> = arrayListOf(values?.get(position)?.url,values?.get(position)?.likes, values?.get(position)?.tags)
                bundle1.putStringArrayList("key1",arrayForBundle)
               findNavController().navigate(R.id.additionalInfoFragment,bundle1)
            }
        }

        fun addList(items:List<itemCatalogs>) {
            values?.addAll(items)
            notifyDataSetChanged()
        }
    }
}