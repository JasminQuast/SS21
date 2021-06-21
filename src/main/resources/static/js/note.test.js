
import { mount } from '@vue/test-utils'
import note from './note.js';
global.axios = {
    get() { return Promise.resolve({ data: [] }) },
    post() { return Promise.resolve('value') }
}

test('shows greetings', () => {
    const wrapper = mount(note, {
        props:{
            title:'hello'
        }
    });
    expect(wrapper.text()).toContain('hello');
})

// //
// // test('should clear name input', async () => {
// //     const wrapper = mount(DynamicForm);
// //     const nameInput = wrapper.find('input[type="text"]');
// //     await nameInput.setValue('Ein neues Produkt');
// //     await wrapper.find('button').trigger('click');
// //     expect(wrapper.vm.$data.nameField).toBe('');
// // })