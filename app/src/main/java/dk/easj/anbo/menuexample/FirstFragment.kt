package dk.easj.anbo.menuexample

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dk.easj.anbo.menuexample.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true) // important
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        binding.fab.setOnClickListener {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        //super.onCreateOptionsMenu(menu, menuInflater)
        menuInflater.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // boolean Return false to allow normal menu processing to proceed, true to consume it here.
        // https://itecnote.com/tecnote/android-should-android-onoptionsitemselected-return-true-or-false/
        Log.d("APPLE", item.toString())
        when (item.itemId) {
            R.id.action_settings ->
                Snackbar.make(binding.firstfragment, "Settings..", Snackbar.LENGTH_LONG).show()
            R.id.action_logout ->
                Snackbar.make(binding.firstfragment, "Logout..", Snackbar.LENGTH_LONG).show()

        }
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}