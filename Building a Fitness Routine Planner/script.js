let routines = JSON.parse(localStorage.getItem('routines')) || [];
let currentRoutineId = null;
let draggedExerciseIndex = null;

function saveRoutines() {
  localStorage.setItem('routines', JSON.stringify(routines));
}

function createRoutine(name) {
  const routine = {
    id: Date.now().toString(),
    name,
    exercises: [],
  };
  routines.push(routine);
  saveRoutines();
  displayRoutines();
  currentRoutineId = routine.id;
  document.getElementById('add-exercise-section').style.display = 'block';
  document.getElementById('routine-name').value = '';
}

function addExerciseToRoutine(exercise, duration) {
  const routine = routines.find(r => r.id === currentRoutineId);
  if (routine && routine.exercises.length < 10) {
    routine.exercises.push({ exercise, duration });
    saveRoutines();
    displayRoutines();
    document.getElementById('exercise').value = ''; 
    document.getElementById('duration').value = ''; 
  } else {
    alert('Maximum of 10 exercises per routine.');
  }
}

function displayRoutines() {
  const routinesList = document.getElementById('routines-list');
  if (routinesList) {
    routinesList.innerHTML = routines.map(routine => `
      <div class="routine">
        <h3>${routine.name}</h3>
        <button onclick="deleteRoutine('${routine.id}')">Delete Routine</button>
        <button onclick="setCurrentRoutine('${routine.id}')">Modify</button>
        <div class="exercises">
          ${routine.exercises.map((exercise, index) => `
            <div class="exercise-item" draggable="true" data-index="${index}" ondragstart="handleDragStart(event)" ondragover="handleDragOver(event)" ondrop="handleDrop(event, '${routine.id}')">
              <p>${exercise.exercise} - ${exercise.duration} minutes</p>
              <button onclick="deleteExercise('${routine.id}', ${index})">Delete</button>
              <button onclick="editExercise('${routine.id}', ${index})">Edit Duration</button>
            </div>
          `).join('')}
        </div>
      </div>
    `).join('');
  }
}

function handleDragStart(event) {
  draggedExerciseIndex = event.target.dataset.index;
  event.dataTransfer.setData('text/plain', event.target.dataset.index);
  event.target.classList.add('dragging');
}

function handleDragOver(event) {
  event.preventDefault();
  event.dataTransfer.dropEffect = 'move';
  const dropTarget = event.target.closest('.exercise-item');
  if (dropTarget) {
    dropTarget.classList.add('drop-target');
  }
}

function handleDragLeave(event) {
  const dropTarget = event.target.closest('.exercise-item');
  if (dropTarget) {
    dropTarget.classList.remove('drop-target');
  }
}

function handleDrop(event, routineId) {
  event.preventDefault();
  const routine = routines.find(r => r.id === routineId);
  if (routine) {
    const dropTarget = event.target.closest('.exercise-item');
    if (dropTarget) {
      dropTarget.classList.remove('drop-target');
      const dropIndex = dropTarget.dataset.index;
      swapExercises(routine, draggedExerciseIndex, dropIndex);
      saveRoutines();
      displayRoutines();
    }
  }
  event.target.classList.remove('dragging');
}

function swapExercises(routine, fromIndex, toIndex) {
  const [movedExercise] = routine.exercises.splice(fromIndex, 1);
  routine.exercises.splice(toIndex, 0, movedExercise);
}

function deleteRoutine(routineId) {
  routines = routines.filter(r => r.id !== routineId);
  saveRoutines();
  displayRoutines();
}

function setCurrentRoutine(routineId) {
  currentRoutineId = routineId;
  document.getElementById('add-exercise-section').style.display = 'block';
}

function deleteExercise(routineId, exerciseIndex) {
  const routine = routines.find(r => r.id === routineId);
  if (routine) {
    routine.exercises.splice(exerciseIndex, 1);
    saveRoutines();
    displayRoutines();
  }
}

function editExercise(routineId, exerciseIndex) {
  const routine = routines.find(r => r.id === routineId);
  if (routine) {
    const newDuration = prompt('Enter new duration (in minutes):', routine.exercises[exerciseIndex].duration);
    if (newDuration !== null && !isNaN(newDuration) && newDuration > 0) {
      routine.exercises[exerciseIndex].duration = parseInt(newDuration);
      saveRoutines();
      displayRoutines();
    } else {
      alert('Please enter a valid duration.');
    }
  }
}

const routineForm = document.getElementById('routine-form');
if (routineForm) {
  routineForm.addEventListener('submit', function (e) {
    e.preventDefault();
    const routineName = document.getElementById('routine-name').value;
    createRoutine(routineName);
  });
}

const exerciseForm = document.getElementById('exercise-form');
if (exerciseForm) {
  exerciseForm.addEventListener('submit', function (e) {
    e.preventDefault();
    const exercise = document.getElementById('exercise').value;
    const duration = document.getElementById('duration').value;
    if (exercise && duration) {
      addExerciseToRoutine(exercise, duration);
    } else {
      alert('Please select a workout and enter a duration.');
    }
  });
}

displayRoutines();