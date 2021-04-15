package hu.bme.aut.incomeexpensenavigationdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.broooapps.otpedittext2.OnCompleteListener
import hu.bme.aut.incomeexpensenavigationdemo.databinding.FragmentPinBinding


class FragmentPIN : Fragment() {

    private var _binding: FragmentPinBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPinBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.etPIN.setOnCompleteListener(OnCompleteListener { value ->
            Toast.makeText(
                activity,
                "Completed $value",
                Toast.LENGTH_SHORT
            ).show()

            if (value.equals("1234")) {
                binding.root.findNavController().navigate(R.id.action_fragmentPIN_to_fragmentChart)
                binding.etPIN.setText("")
            }

        })
    }

}