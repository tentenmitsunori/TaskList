package com.example.tasklist;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PostFragment extends Fragment {
	@Override	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// ���̃t���O�����g�p�̃��C�A�E�g���C���t���[�g����
		View v = inflater.inflate(R.layout.post_fragment, container, false);
		return v;
	}
}
