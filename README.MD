# git-playground

This is a sample project to learn basic features of git and get used to with the commands.

## know your repository
###### While working with git, we must maintain git flow. Which essentially means, there will 2 default branches `master` and `develop`. For any new feature development or bug fix we will clone `develop`. We check in the new changes to the newly created feature branch. We review or validate the changes and merge it to `develop`. Once `develop` has that code we again re-check/re-validate and run our tests and then finally promote the `develop` to `master`. So we make sure our `develop` always has latest working code, which may not be stable and `master` always has stable code which may not be latest.


### getting started

  - Go to a project root directory on PC. example `D:\my-projects`
  - right click and open git bash
  - Run command 
```sh 
git clone https://github.com/subhadippramanik/git-playground.git
``` 
  - now you will see a project directory `git-playground` under your project root directory
  - so you have checked out `develop` branch now
  - in this case you will see only one file `README.md` under this directory, as we don't have added any code for now.
  - now add your code files/directories to this directory `D:\my-projects\git-playground`
  - go to git bash
  - run command
``` sh
cd git-playground
```
  - now we have made some change to the project and to check the changes run 
  ``` sh
git status
```
- this will show list of newly added files/directories in red color, which means there are some changes, but not staged. To `stage` the changes run
```sh
git add <filename>
```
or to add all files
```sh
git add --all
```
- to confirm everything is added run `git status` again and here you should see the same list of files/directories but in green color
- now commit the changeset with a meaningful comment using command
```sh
git commit -m "some meaningful message"
```
- so far everything we have changed, are in local PC and now we are going to push the changes to remote repository
- here comes the git flow in picture, which means we will create feature branch and push the changes to there. Let's assume the feature branch name is `feat-one`. Here is the sequence of commands we run to check in the code along with the new brnach to remote repository.
```sh
git checkout -b feat-one
git push -u origin feat-one
```
- voila... you are done


