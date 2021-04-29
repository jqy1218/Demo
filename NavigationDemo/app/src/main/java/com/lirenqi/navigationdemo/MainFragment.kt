package com.lirenqi.navigationdemo

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val options = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }

        val button = view.findViewById<Button>(R.id.navigate_destination_button)
        button?.setOnClickListener {
//            findNavController().navigate(R.id.flow_step_one_dest, null)
            findNavController().navigate(R.id.flow_step_one_dest, null, options)
        }

        view.findViewById<Button>(R.id.navigate_action_button)?.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.next_action, null)
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_drawer_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.settings_dest) {
//            Navigation.createNavigateOnClickListener(R.id.next_action)
            findNavController().navigate(R.id.settings_dest)
        }
        return super.onOptionsItemSelected(item)
    }

}