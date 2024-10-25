const addForm = document.querySelector("#addForm");

const stdName = document.querySelector("#name");
const age = document.querySelector("#age");
const gender = document.querySelector("[name=stdGen");
const score = document.querySelector("[name=stdScore");

addForm.addEventListener("submit", e=>{
  const inputName = stdName.value.trim();
  const inputAge = age.value.trim();

  if(inputName.length === 0 ){
    e.preventDefault();

    alert("이름을 입력해 주세요");
    stdName.focus();
  }

  if(inputAge.length === 0){
    e.preventDefault();

    alert("나이를 입력해 주세요");
    age.focus();
  }

  if(gender.checked == false){
    e.preventDefault();

    alert("성별을 선택하세요");
  }

  if(score.checked == false){
    e.preventDefault();

    alert("학점을 선택하세요");
  }

})