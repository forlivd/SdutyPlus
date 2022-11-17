package com.d205.sdutyplus.view.pomodoro

import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.view.View
import android.widget.SeekBar
import androidx.fragment.app.activityViewModels
import com.d205.sdutyplus.R
import com.d205.sdutyplus.base.BaseFragment
import com.d205.sdutyplus.databinding.FragmentPomodoroBinding
import com.d205.sdutyplus.uitls.showToast
import com.d205.sdutyplus.view.pomodoro.viewmodel.PomodoroViewModel

class PomodoroFragment: BaseFragment<FragmentPomodoroBinding>(R.layout.fragment_pomodoro) {
    private val pomodoroViewModel: PomodoroViewModel by activityViewModels()
    private var currentCountDownTimer: CountDownTimer? = null
    private var isWorking: Boolean = true

    override fun initOnViewCreated() {
        initView()
    }

    private fun  initView() {
        initBtn()
        initSeekBar()
    }

    private fun initBtn() {
        binding.apply {
            btnPomodoroStart.setOnClickListener {
                btnPomodoroStart.visibility = View.GONE
                btnPomodoroPause.visibility = View.VISIBLE

                startCountDown()
            }
//
            btnPomodoroPause.setOnClickListener {
                btnPomodoroPause.visibility = View.GONE
                btnPomodoroStart.visibility = View.VISIBLE

                stopCountDown()
            }
        }
    }

    private fun initSeekBar() {
        binding.seekBar.apply {
            progress = 25
            updateRemainTime(25 * 60 * 1000L)

            setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(
                        seekBar: SeekBar?,
                        progress: Int,
                        fromUser: Boolean
                    ) {
                        if (fromUser) { // todo 이거뭐임
                                updateRemainTime(progress * 60 * 1000L)
                        }
                    }

                    override fun onStartTrackingTouch(seekBar: SeekBar?) {
                        binding.apply {
                            btnPomodoroPause.visibility = View.GONE
                            btnPomodoroStart.visibility = View.VISIBLE
                        }

                        stopCountDown()
                    }

                    override fun onStopTrackingTouch(seekBar: SeekBar?) {
                        seekBar ?: return

                        if(progress < 1) {
                            seekBar!!.progress = 1
                            updateRemainTime(1 * 60 * 1000L)
                        } else {
                            updateRemainTime(progress * 60 * 1000L)
                        }

                    }
                }
            )
        }
    }


    @SuppressLint("SetTextI18n")
    private fun updateRemainTime(remainMillis: Long) {
        val remainSeconds = remainMillis / 1000

        binding.apply {
            tvMinute.text = "%02d'".format(remainSeconds / 60)
            tvSeconds.text = "%02d".format(remainSeconds % 60)
        }
    }

    private fun stopCountDown() {
        currentCountDownTimer?.cancel()
        currentCountDownTimer = null
    }

    private fun startCountDown() {
        currentCountDownTimer = createCountDownTimer(binding.seekBar.progress * 60 * 1000L)
        currentCountDownTimer?.start()
    }

    private fun createCountDownTimer(initialMillis: Long) =
        object : CountDownTimer(initialMillis, 1000L) {
            override fun onTick(millisUntilFinished: Long) {
                updateRemainTime(millisUntilFinished)
                updateSeekBar(millisUntilFinished)
            }

            override fun onFinish() {
                completeCountDown()
            }
        }

    private fun completeCountDown() {
        updateRemainTime(25)
        updateSeekBar(25)
        binding.apply {
             btnPomodoroPause.visibility = View.GONE
             btnPomodoroStart.visibility = View.VISIBLE
        }
        if(isWorking) {
            requireContext()!!.showToast("완료하였습니다! \n휴식 시간이에요!")
            updateRemainTime(5 * 60 * 1000)
            updateSeekBar(5 * 60 * 1000)
            isWorking = !isWorking
            binding.layoutPomodoro.setBackgroundResource(R.drawable.bg_pomodoro_rest)
        } else {
            requireContext()!!.showToast("진행 시간이에요!")
            updateRemainTime(25 * 60 * 1000)
            updateSeekBar(25 * 60 * 1000)
            isWorking = !isWorking
            binding.layoutPomodoro.setBackgroundResource(R.drawable.bg_pomodoro_work)
        }

    }

    private fun updateSeekBar(remainMillis: Long) {
        binding.seekBar.progress = (remainMillis / 1000 / 60).toInt()
    }



}