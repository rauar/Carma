package com.mutation.eclipse;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate2;

public class MutationLauncher implements ILaunchConfigurationDelegate2 {

	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean finalLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		// TODO Auto-generated method stub
		return false;
	}

	public ILaunch getLaunch(ILaunchConfiguration configuration, String mode) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		// TODO Auto-generated method stub
		return false;
	}

	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		// TODO Auto-generated method stub

	}

}
