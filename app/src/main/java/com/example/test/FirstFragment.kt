package com.example.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.test.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.random_button).setOnClickListener {
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
            val currentCount = showCountTextView.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }

        //Находим кнопку toast по ID и вызываем команду действия по клику
        view.findViewById<Button>(R.id.toast_button).setOnClickListener{
            //Создаем toast, который будет открываться в виде текста на короткое время
            val myToast = Toast.makeText(context, "Hello Toast!", Toast.LENGTH_SHORT)
            //Показываем toast на экране
            myToast.show()
        }

        view.findViewById<Button>(R.id.count_button).setOnClickListener{
            //Метод подсчета ниже
            countMe(view)
        }


    }

    //Создадим метод подсчета (каждый клик добавляет +1 к значению на экране)
    private fun  countMe(view: View){
        //Определим где будет вестись подсчет
        val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
        //Определяем текущее значение счетчика
        val countString = showCountTextView.text.toString()
        //Конвертируем значение в число и добавляем +1
        var count = countString.toInt()
        count++
        //выводим новое значение на экран
        showCountTextView.text = count.toString()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}