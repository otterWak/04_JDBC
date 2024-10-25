const stdNo = new URLSearchParams(location.search).get("stdNo");

console.log(stdNo);

const goToList = document.querySelector("#goToList");

goToList.addEventListener("click", ()=>{
  location.href = "/";
})


const updateBtn = document.querySelector("#updateBtn");
updateBtn.addEventListener("click", ()=>{
  location.href = "/student/update?stdNo=" + stdNo;
})

const deleteBtn = document.querySelector("#deleteBtn");
deleteBtn.addEventListener("click", ()=>{
  if( !confirm("정말 삭제하시겠습니까?") ) return;
  location.href = "/student/delete?stdNo=" + stdNo;
})