package hu.bme.aut.incomeexpensenavigationdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import hu.bme.aut.incomeexpensenavigationdemo.databinding.FragmentChartBinding
import hu.bme.aut.incomeexpensenavigationdemo.databinding.FragmentPinBinding

class FragmentChart : Fragment() {

    private var _binding: FragmentChartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChartBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnEdit.setOnClickListener {
            binding.root.findNavController().navigate(R.id.action_fragmentChart_to_editFragment)
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //DataManager.expense

    }

}